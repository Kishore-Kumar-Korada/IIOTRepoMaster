package com.kishorekumarkorada.IIOTDataVisualizer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.IIOTUserService;
import com.kishorekumarkorada.IIOTDataVisualizer.web.dto.UserDTO;

@RestController
@RequestMapping("/iiot")
public class UserController {

	private IIOTUserService iiotUserService;
	@Autowired
	private TokenStore tokenStore;
	
	//Here Injecting dependencies through constructor
	public UserController(IIOTUserService iiotUserService) {
		System.err.println("Inside UserController's parameterized constructor");
		this.iiotUserService = iiotUserService;
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<IIOTUserModel>> getUserList() {
		System.err.println("Inside UserController->getUserList");
		System.err.println("Tokens: "+tokenStore.findTokensByClientId("clientId"));
		List<IIOTUserModel> iiotUserModels = iiotUserService.getListOfUsers();
		return new ResponseEntity<List<IIOTUserModel>>(iiotUserModels,HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(HttpServletRequest request, @RequestBody UserDTO userDTO) {
		System.err.println("Inside save User");
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			IIOTUserModel result = iiotUserService.save(userDTO);
			return new ResponseEntity<Object>(result,HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			response.put("status", HttpStatus.CONFLICT);
			response.put("message","Trying to Insert Duplicate Values");
			response.put("path", request.getServletPath());
			return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
		} catch (Exception e) {
			response.put("status", HttpStatus.CONFLICT);
			response.put("message",e.getMessage());
			response.put("path", request.getServletPath());
			return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/oauth/logout")
	public ResponseEntity<String> revoke(HttpServletRequest request) {
		System.err.println("Inside revoke tokens");
	    try {
	        String authorization = request.getHeader("Authorization");
	        if (authorization != null && authorization.contains("Bearer")) {
	            String tokenValue = authorization.replace("Bearer", "").trim();

	            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
	            System.err.println("AccessToken: "+accessToken.getValue());
	            System.err.println("Is Token REmoved before: "+tokenStore.findTokensByClientId("clientId"));
	            tokenStore.removeAccessToken(accessToken);
	            System.err.println("Is Token REmoved: "+tokenStore.findTokensByClientId("clientId"));
	            //OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(tokenValue);
	            OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
	            System.err.println("RefreshToken: "+refreshToken.getValue());
	            tokenStore.removeRefreshToken(refreshToken);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Invalid access token");
	    }
	    return ResponseEntity.ok().body("Access token invalidated successfully");
	}
}

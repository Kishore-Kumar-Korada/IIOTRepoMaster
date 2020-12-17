package com.kishorekumarkorada.IIOTDataVisualizer.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
  
  
	@Autowired 
	private UserDetailsService userService; //Added after part of the tutorial
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ClientDetailsService clientDetailsService;
  
	@Override 
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**"); //Here we are using this to control spring security to ignore all the static content resources 
	}
  
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		//Here Any user with the role ADMIN allowed to access this resource
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors().and().csrf().disable()
	  	.authorizeRequests()
	  	.antMatchers("/","/index").permitAll()
	  	.antMatchers("/iiot/auth/api/**","/iiot/api/**").permitAll()
	  	.antMatchers("/iiot/user/**").permitAll()
	  	.antMatchers("/forgot","/reset").permitAll()
	  	.antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
	  	.antMatchers("/about").permitAll() 
	  	.antMatchers("/signup").permitAll()
	  	.antMatchers("/oauth/token").permitAll()
	  	//.antMatchers("/api/**").authenticated()
	  	.anyRequest().authenticated()
	  	.and()
	  	.httpBasic()
	  		.realmName("CRM_REALM");
		
		/*
		 * http.authorizeRequests().antMatchers("/").permitAll()
		 * .antMatchers("/oauth/token").permitAll()
		 * .antMatchers("/test/getDetails").permitAll()
		 * .antMatchers("/iiot/user").permitAll() .antMatchers("/iiot/getUsers")
		 * .hasAnyRole("ADMIN") .anyRequest() .authenticated() .and() .formLogin()
		 * .permitAll() .and() .logout() .permitAll(); http.csrf().disable();
		 */
	}
  
	//Updated after part of the tutorial
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider()); 
	}
  
	//Added after part of the tutorial
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	} 
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
	
	@Bean
	public TokenStore tokenStore() {
		//return new JdbcTokenStore(dataSource);
		return new JwtTokenStore(jwtTokenEnhancer());
	}
	
	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() {
		/*
	    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
	    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
	    */
		//-- for the simple demo purpose, used the secret for signing.
		//-- for production, it is recommended to use public/private key pair
	    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    converter.setSigningKey("Demo-Key-1");
	    
	    return converter;
	}	
	
	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}
	
	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}
	
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
Object.keys(this.state.pokemonData).map(pokemonId => (
	getPokimoncard(pokemonId);
))

Object.keys(this.state.pokemonData).map(pokemonId => (
	console.log("Inside map iteration");
	getPokimoncard(pokemonId)
))

Object.keys(this.state.pokemonData).map(pokemonId => {
	getPokimoncard(pokemonId)  //compile but no output as it won't return anything
})
import React, { useEffect, useState } from "react";

export function Recuperar() {
  const [pokemons, setPokemons] = useState([]);

  useEffect(() => {
    fetch("https://pokeapi.co/api/v2/pokemon/")
      .then((res) => res.json())
      .then((data) => {
        setPokemons(data.results);
      })
      .catch((error) => {
        console.error("Error fetching data: ", error);
      });
  }, []);

  return (
    <div>
      {pokemons
        .filter((pokemon) => pokemon.name === "pikachu")
        .map((filteredPokemon) => (
          <div key={filteredPokemon.name}>{filteredPokemon.name}</div>
        ))}
    </div>
  );
}

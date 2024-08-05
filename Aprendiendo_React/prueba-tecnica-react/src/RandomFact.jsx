import { useState, useEffect } from "react";
import "./App.css";

export function RandomFact() {
  const FACT_CAT_ENDPOINT = "https://catfact.ninja/fact";
  const CAT_IMG_ENDPOINT = "https://cataas.com/cat/says/";

  // Uso del hook useState para almacenar el hecho y la primera palabra
  const [fact, setFact] = useState(null);
  const [url, setUrl] = useState(null);

  // Uso del hook useEffect para obtener el hecho y actualizar la URL de la imagen
  useEffect(() => {
    fetch(FACT_CAT_ENDPOINT)
      .then((res) => res.json())
      .then((data) => {
        setFact(data.fact);
        const firstWord = data.fact.split(" ")[0].trim();
        setUrl(`${CAT_IMG_ENDPOINT}${firstWord}`);
        console.log(firstWord);
      });
  }, []);

  return (
    <main>
      {fact && <p className="fact">fact = {fact}</p>}
      {url && <img src={url} alt="Img de gato por primera palabra" />}
    </main>
  );
}

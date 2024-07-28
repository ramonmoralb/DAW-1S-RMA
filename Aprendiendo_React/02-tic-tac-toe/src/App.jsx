import { useState } from "react";

const TURNS = {
  X: "x",
  O: "o",
};

/*cuadrados del tablero
 * parametros: children (x,o (fichas))
 * updateBoard: funcion que actualiza el tablero
 * index  posicion del Squara
 */
const Square = ({ children, isSelected, updateBoard, index }) => {
  const className = `square ${isSelected ? "is-selected" : ""}`; // ternaria que modifica el className, esto afecta al css

  //maneja el click sobre el tablero son la función updateBoard
  const handleClick = () => {
    updateBoard(index); // recibe el indice para saber donde ha hecho click el usuario, y colocar la ficha correspondiente
  };

  return (
    <div onClick={handleClick} className={className}>
      {children}
    </div>
  );
};

function App() {
  //tablero
  const [board, setBoard] = useState(Array(9).fill(null));

  //turno se inicializa con 'x' setTurn es una funcion que recibe el parametro con el turno y modifica el turn
  const [turn, setTurn] = useState(TURNS.X);

  const updateBoard = (index) => {
    const newBoard = [...board]; // los (...) es un operador de propagación ´Spread Operator' new board contendrá lo mismo que board
    newBoard[index] = turn; //el tablero en el indice recibido, coloca el turn el turn es el string x o procedente del enum TURNS
    setBoard(newBoard);

    const newTurn = turn === TURNS.X ? TURNS.O : TURNS.X; // ternaria que cambia el turno
    setTurn(newTurn); // función del hook useState que modifica el turno
  };

  return (
    <main className="board">
      <h1>Tres en raya</h1>

      <section className="game">
        {/**Este map devuelve un array, el key del square debe de
         * ser un identificador único para que no falle (index lo es en este caso)
         * itera sobre el map inicializado en 9(las 9 posiciones del tablero)
         * el metodo upadteBoard SE DEBE PASAR COMO PARAMETRO NO COMO EJECUCIÓN "upadateBoard()" -> eso no
         *
         */}
        {board.map((_, index) => {
          return (
            <Square key={index} index={index} updateBoard={updateBoard}>
              {board[index]}
            </Square>
          );
        })}
      </section>
      <section className="turn">
        <Square isSelected={turn === TURNS.X}>{TURNS.X}</Square>
        <Square isSelected={turn === TURNS.O}>{TURNS.O}</Square>
      </section>
    </main>
  );
}

export default App;

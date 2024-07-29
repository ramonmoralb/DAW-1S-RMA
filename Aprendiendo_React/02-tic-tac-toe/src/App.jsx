import { useState } from "react";
import confetti from "canvas-confetti";

const TURNS = {
  X: "❌",
  O: "⚪",
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

  const WINNER_COMBOS = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];

  const [winner, setWinner] = useState(null);

  const checkEndGame = (newBoard) => {
    return newBoard.every((square) => square !== null);
  };

  const checkWinner = (boardToCheck) => {
    for (const combo of WINNER_COMBOS) {
      // recorre todo el array de las combinaciones ganadoras y comprueba si hay ganador
      const [a, b, c] = combo;
      if (
        boardToCheck[a] &&
        boardToCheck[a] === boardToCheck[b] &&
        boardToCheck[a] === boardToCheck[c]
      ) {
        return boardToCheck[a];
      }
    }
    return null;
  };

  const resetGame = () => {
    setBoard(Array(9).fill(null));
    setTurn(TURNS.X);
    setWinner(null);
  };

  const updateBoard = (index) => {
    //si la posición no está vacia return
    if (board[index] || winner) return;

    const newBoard = [...board]; // los (...) es un operador de propagación ´Spread Operator' new board contendrá lo mismo que board
    newBoard[index] = turn; //el tablero en el indice recibido, coloca el turn el turn es el string x o procedente del enum TURNS
    setBoard(newBoard);

    //comprobar si hay ganador

    const newTurn = turn === TURNS.X ? TURNS.O : TURNS.X; // ternaria que cambia el turno
    setTurn(newTurn); // función del hook useState que modifica el turno

    const newWinner = checkWinner(newBoard);
    // si hay ganador entra al if y usa el useState setwinner
    if (newWinner) {
      confetti();
      setWinner(newWinner);
    } else if (checkEndGame(newBoard)) {
      setWinner(false);
    }
  };

  return (
    <main className="board">
      <h1>Tres en raya</h1>
      <button onClick={resetGame}>Reset Game</button>
      <section className="game">
        {/**Este map devuelve un array, el key del square debe de
         * ser un identificador único para que no falle (index lo es en este caso)
         * itera sobre el map inicializado en 9(las 9 posiciones del tablero)
         * el metodo upadteGame SE DEBE PASAR COMO PARAMETRO NO COMO EJECUCIÓN "upadateBoard()" -> eso no
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
      {winner !== null && (
        <section className="winner">
          <div className="text">
            <h2>{winner === false ? "Empate" : "Gano :" + winner}</h2>
            <header className="win">
              {winner && <Square>{winner}</Square>}{" "}
              {/*evalua el winner al ser truthy ejecuta el square */}
            </header>
            <button onClick={resetGame}>Empezar de nuevo</button>
          </div>
        </section>
      )}
    </main>
  );
}

export default App;

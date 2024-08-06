import { GetUserByName } from "./GetUserByName";
import { AddUser } from "./AddUser";
import "../src/App.css";
import "../src/index.css";
import { MostrarUsers } from "../MostrarUsers";

function App() {
  return (
    <>
      <MostrarUsers />
      <GetUserByName />
      <AddUser />
    </>
  );
}
export default App;

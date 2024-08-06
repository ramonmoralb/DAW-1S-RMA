import "./App.css";
import { GetUserByName } from "./GetUserByName";
export function Login() {
  return (
    <div>
      <h2>Login Page</h2>
      {/* Aquí va el formulario de login */}
      <GetUserByName />
    </div>
  );
}

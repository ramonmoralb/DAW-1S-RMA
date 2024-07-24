import "./index.css";
import "./App.css";
import { Tw_Follow } from "./Tw_Follow";

export function App() {
  const format = (userName) => `@${userName}`;
  return (
    <section className="App">
      <Tw_Follow
        formatUserName={format}
        userName={"ramon"}
        name={"Ramón Moreno"}
      />

      <Tw_Follow
        formatUserName={format}
        userName={"patricia"}
        name={"Patricia Moreno"}
      />

      <Tw_Follow formatUserName={format} userName={"elonmusk"} name={"elon"} />
    </section>
  );
}

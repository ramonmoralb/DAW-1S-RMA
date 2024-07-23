import "./index.css";
import "./App.css";
import { Tw_Follow } from "./Tw_Follow";

export function App() {
  const format = (userName) => `@${userName}`;
  return (
    <section className="App">
      <Tw_Follow
        isFollow
        formatUserName={format}
        userName={"ramon"}
        name={"Ramon Moreno Albert"}
      />

      <Tw_Follow
        isFollow
        formatUserName={format}
        userName={"patricia"}
        name={"Patricia Moreno"}
      />

      <Tw_Follow
        formatUserName={format}
        isFollow={false}
        userName={"elonmusk"}
        name={"elon"}
      />
    </section>
  );
}

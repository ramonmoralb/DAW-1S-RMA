import { useState } from "react";
export function Tw_Follow({ formatUserName, userName, name }) {
  /*useState recibe es un array en primera posición recibe la variable y en segunda la función que lo modifica
   * el primer parametro que recibe en la declaración marca el estado inicial
   */
  const [isFollow, setIsFollow] = useState(false);
  const text = isFollow ? "Siguiendo" : "Seguir";

  const botonClassName = isFollow
    ? "tw-follow-boton is-follow"
    : "tw-follow-boton";

  const handleClick = () => {
    setIsFollow(!isFollow);
  };

  return (
    <article className="tw-follow">
      <header className="tw-follow-header">
        <img
          className="tw-follow-imagen"
          src={`https://unavatar.io/${userName}`}
          alt="avatar-prueba"
        />
        <div className="tw-follow-info">
          {name}
          <span className="tw-follow-username">{formatUserName(userName)}</span>
        </div>
      </header>

      <aside>
        <button className={botonClassName} onClick={handleClick}>
          {text}
        </button>
      </aside>
    </article>
  );
}

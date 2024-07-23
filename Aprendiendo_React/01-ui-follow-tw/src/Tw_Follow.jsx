export function Tw_Follow({ formatUserName, userName, name, isFollow }) {
  // console.log(isFollow);
  return (
    <article className="tw-follow">
      <header className="tw-follow-header">
        <img
          className="tw-follow-imagen"
          src={`https://unavatar.io/${userName}`}
          alt="avatar-prueba"
        />
        <div className="tw-follow-info">
          <strong>{name}</strong>
          <span className="tw-follow-username">{formatUserName(userName)}</span>
        </div>
      </header>

      <aside>
        <button className="tw-follow-boton">Follow</button>
      </aside>
    </article>
  );
}

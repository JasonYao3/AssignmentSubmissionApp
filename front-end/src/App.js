import { useEffect, useState } from 'react';
import './App.css';
import {useLocalState} from "./util/useLocalStorage";

function App() {
  const [jwt, setJwt] = useLocalState("", "jwt");

  useEffect(() => {
    if (!jwt) {
      const reqBody = {
        username: "jason",
        password: "asdasd",
      };
    
      fetch('api/auth/login', {
        headers: {
          "Content-Type": "application/json",
        },
        method : "post",
        body: JSON.stringify(reqBody),
      })
      .then((response) => Promise.all([response.json(), response.headers]))
      .then(([body, headers]) => {
        setJwt(headers.get("authorization"));
      });
    }
  }, [jwt]);

  useEffect(() => {
    console.log(`we have the JWT: ${jwt}`);
  }, [jwt])
  
  return (
    <div className="App">
      <h1>Hello world</h1>
      <div>JWT Value is {jwt}</div>
    </div>
  );
}

export default App;

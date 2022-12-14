import { useEffect } from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import "./App.css";
import AssignmentView from "./AssignmentView";
import Dashboard from "./Dashboard";
import Homepage from "./Homepage";
import Login from "./Login";
import PrivateRoute from "./PrivateRoute";
import { useLocalState } from "./util/useLocalStorage";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [jwt, setJwt] = useLocalState("", "jwt");

  // useEffect(() => {
  //   if (!jwt) {
  //     const reqBody = {
  //       username: "jason",
  //       password: "asdasd",
  //     };

  //     fetch("api/auth/login", {
  //       headers: {
  //         "Content-Type": "application/json",
  //       },
  //       method: "post",
  //       body: JSON.stringify(reqBody),
  //     })
  //       .then((response) => Promise.all([response.json(), response.headers]))
  //       .then(([body, headers]) => {
  //         setJwt(headers.get("authorization"));
  //       });
  //   }
  // }, [jwt]);

  useEffect(() => {
    console.log(`we have the JWT: ${jwt}`);
  }, [jwt]);

  return (
    <Routes>
      <Route
        path="/dashboard"
        element={
          <PrivateRoute>
            <Dashboard />
          </PrivateRoute>
        }
      />
      <Route
        path="/assignments/:id"
        element={
          //<PrivateRoute>
          <AssignmentView />
          // </PrivateRoute>
        }
      />
      <Route path="/login" element={<Login />} />
      <Route path="/" element={<Homepage />} />
    </Routes>
  );
}

export default App;

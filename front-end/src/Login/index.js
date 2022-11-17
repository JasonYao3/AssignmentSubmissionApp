import React from "react";

const Login = () => {
  return (
  //react fragment <>
    <>
      <div>
        <label htmlFor="username">Username</label>
        <input type="email" id="username" />
      </div>
      <div>
      <label htmlFor="password">Password</label>
        <input type="password" id="password" />
      </div>
    </>
  );
};

export default Login;

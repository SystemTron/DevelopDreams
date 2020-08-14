import React from 'react';
import Home from './components/home/Home'
import {BrowserRouter ,Route} from 'react-router-dom';
import Login from './components/Login/login';
import SignUp from './components/Login/signup';


function App() {
  return (
    <>
      <div >
        <BrowserRouter>
        <Route exact path="/">
          <Home/>
        </Route>
        <Route exact path="/login" component={Login}>
          <Login/>
        </Route>
        <Route exact path="/signup" component={SignUp}>
          <SignUp/>
        </Route>
        </BrowserRouter>
      </div>
    </>
  );
}

export default App;

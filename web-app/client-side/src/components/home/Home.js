import React from 'react';
import Header from '../header'
import Loginhome from '../Login/loginhome'
import { BrowserRouter ,Route} from 'react-router-dom';
import Login from '../Login/login';

function Home() {
  return (
    <>
      <div >
           <Loginhome/>
      </div>
    </>
  );
}

export default Home;
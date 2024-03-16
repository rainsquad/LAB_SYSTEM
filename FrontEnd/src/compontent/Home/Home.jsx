import React from 'react';
import { Link } from "react-router-dom";
import './Home.css'; // Import the CSS file for Home component
import Nav from '../Nav';


const Home = () => {
 return (
  <div>
<Nav></Nav>
    <div className="home-content">
      <div className="right-bg">
        <img className="position-absolute w-100 h-100 rounded"  style={{ objectFit: 'cover' }} alt="Right background" />
      </div>
      <div className="text-content">
        <h1>Join E-Medical  </h1>
        <h1>For the best expirience</h1>
        <div className="button-container">
          <Link to="/Login" className="btn btn-dark mr-4">Login</Link>
          <Link to="/register" className="btn btn-secondary">Sign Up</Link>
        </div>
      </div>
    </div>
  </div>
 );
}

export default Home;

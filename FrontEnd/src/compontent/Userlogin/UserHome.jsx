import React from 'react';
import './UserHome.css'; 
import { Link } from "react-router-dom";

const UserHome = () => {
 return (
  <div>
    <nav className="navbar">
      <h className="logo">LabNet</h>
      <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/appointmentbooking">Get an Appoinment</a></li>
    
      </ul>
    </nav>
    <div className="home-content">
      <div className="right-bg">
       
      </div>
      <div className="text-content">
        <h1>Join E-Medical </h1>
        <h1>For the best expirience</h1>
        <div className="button-container">
          <Link to="/appointmentbooking" className="btn btn-dark mr-4">Appoinments</Link>
          <Link to="/pay" className="btn btn-secondary">Payment</Link>
        </div>
      </div>
    </div>
  </div>
 );
}

export default UserHome;

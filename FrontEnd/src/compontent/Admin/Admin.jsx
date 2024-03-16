import React from 'react';
import { Link } from "react-router-dom";
import './Admin.css'; 
import Nav from '../Nav';


const Admin = () => {
 return (
  <div>
   <Nav></Nav>
    <div className="home-content">
      <div className="right-bg">
        <img className="position-absolute w-100 h-100 rounded"  style={{ objectFit: 'cover' }} alt="Right background" />
      </div>
      <div className="text-content">
        <h1>Join E-Medical </h1>
        <h1>For the best expirience</h1>
        <div className="button-container">
          <Link to="/Getusers" className="btn btn-primary mr-4">Users</Link>
          <Link to="/Getallappointment" className="btn btn-secondary">Appointments </Link>
        </div>
      </div>
    </div>
  </div>
 );
}

export default Admin;

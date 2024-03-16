
import React from 'react';
import './Paymentform.css'; 
import { Link } from "react-router-dom";
import Nav2 from '../Nav/nav2';

const PaymentDetails = () => {
  return (
    <>
      <Nav2></Nav2>
      <div className="home-content">
      <div className="right-bg">
      
      <div className="container1">
        <h1 className="h1">Payment</h1>
        <form id="payment-form">
          <div className="form-group">
            <label htmlFor="card-number">Card Number</label>
            <input type="text" id="card-number" placeholder="Enter card number" className="input-field" />
          </div>
          <div className="form-group">
            <label htmlFor="expiry">Expiration Date</label>
            <input type="text" id="expiry" placeholder="MM/YY" className="input-field" />
          </div>
          <div className="form-group">
            <label htmlFor="cvc">CVC</label>
            <input type="text" id="cvc" placeholder="Enter CVC" className="input-field" />
          </div>
          <div className="button-container1">
          <Link to="/userhome" className="btn btn-secondary">Pay Now</Link>
          </div>
          <div id="error-message" className="error-message"></div>
        </form>
      </div>
      </div>
      </div>
    </>
  );
};

export default PaymentDetails;

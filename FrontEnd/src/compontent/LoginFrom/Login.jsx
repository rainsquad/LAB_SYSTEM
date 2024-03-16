import React, { useState } from "react";
import { Container, Row, Col, Form, Button, Nav } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import './LoginStyle.css';
import { api_url } from "../../constants";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    if (!email.trim() || !password.trim()) {
      alert("Please enter both email and password.");
      return;
    }
    await axios.post(
      api_url + "Users/login",
      {
        email: email,
        password: password,
      }
    ).then((response) => {

      if (response.data.message === "Email not exists") {
        alert("Email does not exist");
      } else if (response.data.status === true) {

        const isAdmin = email === "admin@example.com";
        if (isAdmin) {
          navigate("/AdminHome");
        } else {
          navigate("/UserHome");
        }
      } else {
        alert("Incorrect Email and Password not match");
      }

    }).catch((error) => {
      alert("An error occurred while logging in.");
    });


  }

  return (
    <>
    <Nav></Nav>
      <div className="home-content">
        <div className="right-bg">
          <Container fluid className="login-container">
            <Row className="justify-content-center">
              <Col md={6}>
                <div className="login-form">
                  <h2 className="text-center"><center>Login</center></h2>
                  <Form onSubmit={login} noValidate>
                    <Form.Group controlId="email">
                      <Form.Label>Email</Form.Label>
                      <Form.Control
                        type="email"
                        name="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="Enter your email"
                      />
                    </Form.Group>
                    <Form.Group controlId="password">
                      <Form.Label>Password</Form.Label>
                      <Form.Control
                        type="password"
                        name="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Enter your password"
                      />
                    </Form.Group>
                    <div className="text-center">
                      <Button variant="primary" type="submit">
                        Login
                      </Button>
                    </div>
                  </Form>
                </div>
              </Col>
            </Row>
          </Container>
        </div></div>
    </>
  );
}

export default Login;

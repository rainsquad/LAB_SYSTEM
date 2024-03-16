import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from "./compontent/RegisterFrom/Register";
import Login from "./compontent/LoginFrom/Login";
import AppointmentForm from "./compontent/Appointmentbooking/AppointmentForm";
import Home from "./compontent/Home/Home";
import UserHome from "./compontent/Userlogin/UserHome";
import PaymentDetails from "./compontent/Payment/PaymentDetails"
import Admin from "./compontent/Admin/Admin";
import GetUsers from "./compontent/Get Users/GetUsers";
import GetAppointments from "./compontent/GetAppointment/Getappointment";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/appointmentbooking" element={<AppointmentForm />} />
          <Route path="/" element={<Home />} />
          <Route path="/userhome" element={<UserHome />} />
          <Route path="/pay" element={<PaymentDetails />} />
          <Route path="/Admin" element={<Admin />} />
          <Route path="/Getusers" element={<GetUsers />} />
          <Route path="/Getallappointment" element={<GetAppointments />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Nav from '../Nav';

const GetUsers = () => {
  const [users, setUsers] = useState([]);
  const [editingUser, setEditingUser] = useState(null);
  const [editedUserName, setEditedUserName] = useState("");
  const [editedUserType, setEditedUserType] = useState("");
  const [editedEmail, setEditedEmail] = useState("");
  const [editedMobile, setEditedMobile] = useState("");

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
   
      const response = await axios.get("http://localhost:8080/api/v1/Register/getall").then((response)=>{
        setUsers(response.data);
      }).catch((error)=>{
        alert('Error fetching users:'+ error);
      });
      
    
  };

  const editUser = (user) => {
    setEditingUser(user);
    setEditedUserName(user.userName);
    setEditedUserType(user.userType);
    setEditedEmail(user.email);
    setEditedMobile(user.mobile);
  };

  const cancelEdit = () => {
    setEditingUser(null);
  };

  const updateUser = async () => {
    
      await axios.put(`http://localhost:8080/api/v1/Register/edit/${editingUser._id}`, {
        userName: editedUserName,
        userType: editedUserType,
        email: editedEmail,
        mobile: editedMobile
      }).then((response)=>{
        alert("User details updated successfully");
        fetchUsers(); // Refresh the user list after update
        setEditingUser(null); // Clear the editing state
      }).catch((error)=>{
        alert('Error updating user:', error);
        alert("Failed to update user details");
      });

  
  };

  const deleteUser = async (userId) => {
 
      await axios.delete(`http://localhost:8080/api/v1/Register/delete/${userId}`).then((response)=>{
        alert("User deleted successfully");
        fetchUsers(); 
      }).catch((error)=>{
        alert('Error deleting user:'+ error);
      });
      
   
  };

  return (
    <div>
      <Nav></Nav>
      <br />
      <table className="table table-dark" align="center">
        <thead>
          <tr>
            <th scope="col">User Name</th>
            <th scope="col">User Type</th>
            <th scope="col">Email</th>
            <th scope="col">Mobile</th>
            <th scope="col">Option</th>
          </tr>
        </thead>
        <tbody>
          {users.map(user => (
            <tr key={user._id}>
              <td>{user.userName}</td>
              <td>{user.userType}</td>
              <td>{user.email}</td>
              <td>{user.mobile}</td>
              <td>
                <button type="button" className="btn btn-warning" onClick={() => editUser(user)}>Edit</button>
                <button type="button" className="btn btn-danger" onClick={() => deleteUser(user._id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {editingUser && (
        <div className="edit-user-modal">
          <h2>Edit User</h2>
          <label>User Name: <input type="text" value={editedUserName} onChange={(e) => setEditedUserName(e.target.value)} /></label>
          <label>User Type: <input type="text" value={editedUserType} onChange={(e) => setEditedUserType(e.target.value)} /></label>
          <label>Email: <input type="email" value={editedEmail} onChange={(e) => setEditedEmail(e.target.value)} /></label>
          <label>Mobile: <input type="text" value={editedMobile} onChange={(e) => setEditedMobile(e.target.value)} /></label>
          <button onClick={updateUser}>Save Changes</button>
          <button onClick={cancelEdit}>Cancel</button>
        </div>
      )}
    </div>
  );
};

export default GetUsers;

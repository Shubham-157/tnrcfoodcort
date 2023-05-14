import React, { useState } from 'react'
import { NavLink } from 'react-router-dom';
import { Navbar } from 'react-bootstrap';
import Logo from '../logos/Logo.jpeg'
import './Login.css'
import { useForm } from 'react-hook-form';
import axios from 'axios';
import Api from './Api';
import { useNavigate } from 'react-router-dom';

const Login = () => {

  const logo = Logo;
  let navigate = useNavigate();

  const [email,setEmail] = useState('');
  const [password,setPassword] = useState('');

  const handleEmail = (e) => {
    setEmail(e.target.value)
  }

  const handlePassword = (e) => {
    setPassword(e.target.value)
  }

  const {register,formState: { errors },handleSubmit} = useForm();
  const handleApi = () => {
    
    axios.post(Api + 'signin', {
      email : email,
      password : password
    }).then((result) => {
        console.log(result);
        alert("Successfully Logged In")
        localStorage.setItem('token',result.data.token)
        navigate('/Home');
    }).catch((err) => {
        alert(err.response.data);
        console.log(err);
    })
}

  return (

    <>
      <Navbar className='container d-flex justify-content-between align-items-center' bg="dark" variant="dark" style={{ height: "80px" }}>

        <NavLink to="/" >
          <img href="/" src={logo} style={{ width: "12rem", position: "relative", cursor: "pointer" }} alt=''></img>
        </NavLink>

        <h1 className='text-light container d-flex justify-content-center align-items-center' >The Nashik Restaurant Cluster</h1>
        <NavLink to="/Register" className="text-decoration-none text-light mx-3" style={{ width: "8rem", fontSize: 22 }}>Register</NavLink>
      </Navbar>
      <div class="yoo container d-flex justify-content-center  px-1 py-5 mx-auto">
        <div class=" container d-flex justify-content-center ">
          <div class="bg-white  text-center" style={{ borderRadius: "10px" }}>


            <div class="cardl container d-flex" style={{ width: "30rem" }}>

            <form onSubmit={handleSubmit(handleApi)}>
        <input
          type="email"
          class="form-control"
          placeholder="email-id"
          value ={email}
          onChange ={handleEmail}
          required
         //{...register("email", { required: true })}
        />
        {errors.email?.type === "required" && (
          <p role="alert">emailId is required</p>
        )}
        <br />
        <input
          type="password"
          class="form-control"
          placeholder="password"
          value={password}
          onChange={handlePassword}
          required
         // {...register("password", { required: true })}
        />
        {errors.password?.type === "required" && (
          <p role="alert">password is required</p>
        )}
        <br />
        <button className='text-white' style={{backgroundColor:"green"}}>Login</button>
      </form>
            </div>
          </div>
        </div>
      </div>
    </>

  )
}

export default Login
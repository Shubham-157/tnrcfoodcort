import React from 'react'
import { NavLink } from 'react-router-dom';
import { Navbar } from 'react-bootstrap';
import Logo from '../logos/Logo.jpeg'
import { useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import axios from 'axios';
import Api from './Api';
 
const Register = () => {

  const logo = Logo;

  let navigate = useNavigate();
    
    const { register, formState: { errors }, handleSubmit } = useForm();
    const onSubmit = (data) => {
        console.log(data);
        axios.post(Api + 'signup', data).then((result) => {
            console.log(result);
            alert("Registered Successfully");
            navigate('/');
        }).catch((err) => {
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
        <NavLink to="/" className="text-decoration-none text-light mx-3" style={{ width: "8rem", fontSize: 22 }}>Log-In</NavLink>
      </Navbar>
      <div class="yoo container justify-content-center py-3 mx-auto">
        <div class=" container  justify-content-center ">



          <div class="cardl bg-white container " style={{ width: "30rem" }}>

          <form onSubmit={handleSubmit(onSubmit)}>
        <input
          type="text"
          class="form-control"
          placeholder="First name"
          {...register("firstName", { required: true })}
        />
        {errors.firstName?.type === "required" && (
          <p role="alert">First name is required</p>
        )}
        <br />
        <input
          type="text"
          class="form-control"
          placeholder="Last name"
          {...register("lastName", { required: true })}
        />
        {errors.lastName?.type === "required" && (
          <p role="alert">Last name is required</p>
        )}
        <br />
        <input
          type="email"
          class="form-control"
          placeholder="email-id"
          {...register("email", { required: true })}
        />
        {errors.email?.type === "required" && (
          <p role="alert">emailId is required</p>
        )}
        <br />
        <input
          type="password"
          class="form-control"
          placeholder="password"
          {...register("password", { required: true })}
        />
        {errors.password?.type === "required" && (
          <p role="alert">password is required</p>
        )}
        <br />
        <button className='text-white' style={{backgroundColor:"green"}}> Register</button>
      </form>
          </div>
        </div>
      </div>

    </>

  )
}

export default Register
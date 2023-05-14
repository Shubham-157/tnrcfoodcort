import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import axios from 'axios';
import Api from './Api';
import { useNavigate } from 'react-router-dom';

const ContactForm = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [formStatus, setFormStatus] = useState('Submit');

  const navigate = useNavigate();
  const { register, formState: { errors }, handleSubmit } = useForm();

  const handleName = (e) => {
    setName(e.target.value);
  };

  const handleEmail = (e) => {
    setEmail(e.target.value);
  };

  const handleMessage = (e) => {
    setMessage(e.target.value);
  };

  const onSubmit = (data) => {
    setFormStatus('Submitting...');
    axios.post('http://localhost:8080/contact', {
      name: name,
      email: email,
      message: message
    })
      .then((result) => {
        console.log(result);
        alert("Responce Submitted Successfully");
        navigate('/Home');
      })
      .catch((err) => {
        alert(err.response.data);
        console.log(err);
      })
      .finally(() => {
        setFormStatus('Submit');
      });
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-3">React Contact Form Component Example</h2>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="mb-3">
          <label className="form-label" htmlFor="name">
            Name
          </label>
          <input
            className="form-control"
            type="text"
            id="name"
            {...register('name', { required: true })}
            value={name}
            onChange={handleName}
          />
          {errors.name && <span className="text-danger">This field is required</span>}
        </div>
        <div className="mb-3">
          <label className="form-label" htmlFor="email">
            Email
          </label>
          <input
            className="form-control"
            type="email"
            id="email"
            {...register('email', { required: true })}
            value={email}
            onChange={handleEmail}
          />
          {errors.email && <span className="text-danger">This field is required</span>}
        </div>
        <div className="mb-3">
          <label className="form-label" htmlFor="message">
            Message
          </label>
          <textarea
            className="form-control"
            id="message"
            {...register('message', { required: true })}
            value={message}
            onChange={handleMessage}
          />
          {errors.message && <span className="text-danger">This field is required</span>}
        </div>
        <button className="btn btn-danger" type="submit" disabled={formStatus === 'Submitting...'}>
          {formStatus}
        </button>
      </form>
    </div>
  );
};

export default ContactForm;

import React, { useEffect, useState } from 'react'
import Logo from '../logos/Logo.jpeg'
import Badge from '@mui/material/Badge'
import Menu from '@mui/material/Menu';
import { NavLink } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import {  Nav, NavDropdown, NavItem, Navbar } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import Table from 'react-bootstrap/Table';
import { DLT } from '../redux/actions/action';
import Button from 'react-bootstrap/Button';
import ContactFrom from './ContactForm';


const Header = () => {

  const [price,setPrice] = useState([]);

  const logo = Logo;

  const getdata = useSelector((state) => state.cartreducer.carts);
  console.log(getdata);

  const dispatch = useDispatch();

  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const dlt = (id)=>{
    dispatch(DLT(id))
  }

  const total = ()=>{
    let price = 0;
    getdata.map((ele,k)=>{
      price = ele.price * ele.qnty + price;
    });
    setPrice(price);
  };

  useEffect(()=>{
    total();
  },[total])
  const navigate = useNavigate();
  function Logout()
  {
    localStorage.clear();
    navigate('/')
  }

  return (
    <>
      <Navbar className='container d-flex justify-content-between align-items-center' bg="dark" variant="dark" style={{ height: "80px" }}>

        <NavLink to="/Home" >
          <img href="/" src={logo} style={{ width: "12rem", position: "relative", cursor: "pointer" }} alt='' className='mt-2.5'></img>
        </NavLink>

        <h1 className='text-light' >The Nashik Restaurant Cluster</h1>

        <Badge badgeContent={getdata.length} color="primary" style={{ right: "5%" }}
          id="basic-button"
          aria-controls={open ? 'basic-menu' : undefined}
          aria-haspopup="true"
          aria-expanded={open ? 'true' : undefined}
          onClick={handleClick}
        >
          <i class="fa-sharp fa-solid fa-cart-shopping text-light " style={{ fontSize: 40, cursor: "pointer" }}></i>
        </Badge>

        <Menu
          id="basic-menu"
          anchorEl={anchorEl}
          open={open}
          onClose={handleClose}
          MenuListProps={{
            'aria-labelledby': 'basic-button',
          }}
        >

          {
            getdata.length ?
              <div className='card_details' style={{ width: "29.5rem", padding: 10 }}>
                <Table>
                  <thead>
                    <tr>
                      <th>Photo</th>
                      <th>Item Name</th>
                    </tr>
                  </thead>
                  <tbody>
                    {
                      getdata.map((e)=>{
                        return(
                          <>
                            <tr>
                              <td>
                                <NavLink to={`/cart/${e.id}`} onClick={handleClose}>
                                  <img src={e.imageURL} style={{width:"5rem",height:"5rem" }}></img>
                                </NavLink>
                                
                              </td>
                              <td>
                                <p>{e.name}</p>
                                <p>Price : ₹ {e.price}</p>
                                <p>Quantity : {e.qnty}</p>
                                <p style={{color:"red",fontSize:20,cursor:"pointer"}} onClick={()=>dlt(e.id)}>
                                  <i className='fas fa-trash smalltrash'></i>
                                </p>
                              </td>
                              <td className='mt-5' style={{color:"red",fontSize:20,cursor:"pointer"}} onClick={()=>dlt(e.id)}>
                              <i className='fas fa-trash'></i>
                              </td>
                            </tr>
                          </>
                        )
                      })
                    }
                    
                    
                  </tbody>
        
                </Table>
                <div className='container d-flex justify-content-between align-items-center'>
                      <h3 className='text-center'>Total : ₹ {price}</h3>
                      <NavLink to="/Checkout" className="text-decoration-none" onClick={handleClose}>
                    <Button variant="success"  style={{ width: "10rem",height:"3rem", fontSize:22,fontFamily:"inherit" }}>Checkout{" >"}</Button>
                </NavLink>
                    </div>
                
              </div> :

              <div className='card_details d-flex justify-content-center align-items-center' style={{ width: "20rem", height: "9.59rem", padding: 1, position: 'relative', backgroundColor:"#87CEEB"}}>
                <i className='fas fa-close smallclose'
                  onClick={handleClose}
                  style={{ position: "absolute", top: 2, right: 20, fontSize: 28, cursor: "pointer" }}></i>
                <p style={{ fontSize: 22 }}>Your Cart is Empty</p>

                <iframe src="https://giphy.com/embed/Aik2hwXn0dUTrVkbIP" className='emptycart_img' style={{ width: "5rem", padding: 10 }}></iframe>
              </div>
          }
        </Menu>
        
        <Nav>
        <li class="nav-item">
          <a class="nav-link" href="/ContactForm">Contact Us</a>
        </li>
          <NavDropdown title= "Foodie">
            <NavDropdown.Item onClick={Logout}> Logout </NavDropdown.Item>
          </NavDropdown>
        </Nav>
      </Navbar>
    </>
  )
}

export default Header
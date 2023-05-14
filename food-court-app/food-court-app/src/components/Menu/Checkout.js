import React, { useEffect, useState } from 'react'
import "../style.css"
import Table from 'react-bootstrap/Table';
import { NavLink } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import Header from '../Header';
import { useSelector } from 'react-redux';

const Checkout = () => {

  const [price, setPrice] = useState(0);

  const getdata = useSelector((state) => state.cartreducer.carts);
  console.log(getdata);

  const total = () => {
    let price = 0;
    getdata.map((ele, k) => {
      price = ele.price * ele.qnty + price;
    });
    setPrice(price);
  };

  useEffect(() => {
    total();
  }, [total])


  return (
    <>
    <Header></Header>
      <NavLink to="/Menu1" className="text-decoration-none mx-1">
        <h3 style={{ width: "18rem", position: "relative", left: "10%", color: "black" }} alt='' className='mt-1'>{"< "}Back to Menu Page</h3>
      </NavLink>
      <div className=' container d-flex justify-content-center align-items-center'>

        {
          getdata.length ?
            <div style={{ width: "32rem" }}>
              <Table >
                <thead>
                  <tr>
                  <th>Order Details</th>
                  </tr>
                  <tr>
                    <th>Photo</th>
                    <th>Item Name</th>
                  </tr>
                </thead>
                <tbody>
                  {
                    getdata.map((e) => {
                      return (
                        <>
                          <tr>
                            <td>
                              <img src={e.imageURL} style={{ width: "5rem", height: "5rem" }}></img>
                            </td>
                            <td>
                              <p>{e.name}</p>
                              <p>Price : ₹ {e.price}</p>
                              <p>Quantity : {e.qnty}</p>
                            </td>

                          </tr>
                        </>
                      )
                    })
                  }
                </tbody>

              </Table>
              <h2 className='text-center '>Total : ₹ {price}</h2>
            </div> :

            <div className='card_details d-flex justify-content-center align-items-center' style={{ width: "20rem", height: "9.59rem", padding: 1, position: 'relative', backgroundColor: "#87CEEB" }}>

              <p style={{ fontSize: 22 }}>Your Cart is Empty</p>

              <iframe src="https://giphy.com/embed/Aik2hwXn0dUTrVkbIP" className='emptycart_img' style={{ width: "5rem", padding: 10 }}></iframe>
            </div>
        }
       
      </div>
      <div>
      <NavLink to="" className="text-decoration-none container d-flex mb-4" >
        <Button variant="danger" style={{ width: "10rem", height: "3rem",position:"relative", fontSize: 22, fontFamily: "inherit",left:"80%"}}>Payment</Button>
      </NavLink>
      </div>
    </>
  )
}


export default Checkout
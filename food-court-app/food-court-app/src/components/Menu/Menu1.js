import React, { useEffect, useState } from 'react'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import "../style.css"
import { useDispatch } from 'react-redux';
import { ADD } from "../../redux/actions/action"
import Header from '../Header';
import axios from 'axios';

const Menu1 = () => {

  const [menu1,setMenu1] = useState([]);

  useEffect(()=>{
      loadMenu1();
  },[]);

  const loadMenu1 = async() => {
    const result = await axios.get("http://localhost:8080/product/shops/1/products");
    setMenu1(result.data);
  }

  const dispatch = useDispatch();

  const send = (e)=>{
    dispatch(ADD(e));
  }

  return (
    <>
    <Header></Header>
    <div className='container mt-3'>
      <h1 className='text-center'>Available Menu Items are</h1>

      <div className='row d-flex justify-content-center align-items-center'>
        {
          menu1.map((element, id) => {
            return (
              <>
                <Card style={{ width: '22rem' , border:"none"}} className="mx-2 mt-4 card_style">
                  <Card.Img variant="top" src={element.imageURL} style={{height:"16rem"}} className="mt-3"/>
                  <Card.Body>
                    <Card.Title>{element.name}</Card.Title>
                    <Card.Text>
                     Price : ₹ {element.price}
                    </Card.Text>
                    <div className='button_div d-flex justify-content-center'>
                      <Button variant="primary" onClick={()=>send(element)} className='col-lg-12'>Add to Cart</Button>
                    </div>
                    
                  </Card.Body>
                </Card>
              </>
            )
          })
        }

      </div>
    </div>
    </>
  )
}

export default Menu1
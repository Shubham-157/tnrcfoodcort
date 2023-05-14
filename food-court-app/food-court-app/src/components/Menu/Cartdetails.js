import React, { useEffect, useState } from 'react'
import "../style.css"
import Table from 'react-bootstrap/Table';
import { NavLink, useNavigate, useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { DLT } from '../../redux/actions/action';
import { ADD, REMOVE } from "../../redux/actions/action"
import Header from '../Header';

const Cartdetails = () => {

    const { id } = useParams();

    const [data, setData] = useState([]);

    const history = useNavigate();

    const dispatch = useDispatch();

    const getdata = useSelector((state) => state.cartreducer.carts);

    const compare = () => {
        let comparedata = getdata.filter((e) => {
            return e.id == id
        });
        setData(comparedata);
    }

    //add
    const send = (e) => {
        dispatch(ADD(e));
    }

    const dlt = (id) => {
        dispatch(DLT(id));
        history("/Menu1")
    }


    //remove one
    const remove = (item) => {
        dispatch(REMOVE(item))
    }

    useEffect(() => {
        compare();
    }, [id])

    return (
        <>
        <Header></Header>
            <div className='container mt-2'>
                <h2 className='text-center'>Item Details</h2>
                <NavLink to="/Menu1" className="text-decoration-none mx-1">
                    <h3 style={{ width: "18rem", position: "relative", left: "10%", color: "black" }} alt='' className='mt-1'>{"< "}Back to Menu Page</h3>
                </NavLink>
                <section className='container mt-2'>
                    <div className='itemdetails'>
                        {
                            data.map((ele) => {
                                return (
                                    <>
                                        <div className='items_img'>
                                            <img src={ele.imageURL}></img>
                                        </div>
                                        <div className='details'>
                                            <Table>
                                                <tr>
                                                    <td>
                                                        <p className='mt-2'> <strong>Item</strong> : {ele.name}</p>
                                                        <p> <strong>Price</strong> : ₹ {ele.price}</p>
                                                       
                                                        <p> <strong>Total</strong> : ₹ {ele.price * ele.qnty}</p>
                                                        <div className='mt-3 d-flex justify-content-between align-items-center' style={{ width: 100, cursor: "pointer", background: "#ddd", color: "#111" }}>
                                                            <span style={{ fontSize: 24 }} onClick={ele.qnty <= 1 ? () => dlt(ele.id) : () => remove(ele)}>-</span>
                                                            <span style={{ fontSize: 22 }}>{ele.qnty}</span>
                                                            <span style={{ fontSize: 24 }} onClick={() => send(ele)}>+</span>
                                                        </div>
                                                        <p><strong>Remove</strong> : <span><i className='fas fa-trash mt-4' onClick={() => dlt(ele.id)} style={{ color: "red", fontSize: "20", cursor: "pointer" }}></i></span></p>
                                                    </td>
                                                    
                                                </tr>
                                            </Table>

                                        </div>

                                    </>
                                );

                            })

                        }
                    </div>
                </section>
            </div>
        </>

    )
}

export default Cartdetails
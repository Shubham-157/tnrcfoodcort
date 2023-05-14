import React, { useEffect, useState } from 'react'
import Card from 'react-bootstrap/Card'
import "./style.css"
import { NavLink } from 'react-router-dom';
import axios from 'axios';

function Cards({ }) {

    const [shops, setShops] = useState([]);

    useEffect(() => {
        loadShops();
    }, []);

    const loadShops = async () => {
        const result = await axios.get("http://localhost:8080/shops");
        setShops(result.data);
    }

    return (
        <>
            {
                shops.map((element, index) => {
                    return (
                        <>
                            <Card style={{ width: '40rem', border: "none", paddingRight: "50px", paddingLeft: "50px" }} className="hove mb-3">
                                <NavLink className='text-decoration-none' to={element.menu} role="button">
                                    <Card.Img variant="top" className='cd' src={element.imgurl} />
                                    <div className='card_body'>
                                        <div className="upper_data d-flex justify-content-between align-items-center ">
                                            <h4 className='mt-2'>{element.name}</h4>
                                            <span>3.5&nbsp;★</span>
                                        </div>
                                        <div className='extra'></div>

                                        <div className='last_data d-flex justify-content-between align-items-center'>
                                            <img src="https://b.zmtcdn.com/data/o2_assets/4bf016f32f05d26242cea342f30d47a31595763089.png?output-format=webp" className="limg"></img>
                                            <p>Hungry? "Taste best food from us"</p>
                                            <img src="https://b.zmtcdn.com/data/o2_assets/0b07ef18234c6fdf9365ad1c274ae0631612687510.png?output-format=webp" className="laimg"></img>
                                        </div>

                                    </div>
                                </NavLink>
                            </Card>

                        </>
                    )
                })
            }
        </>
    )
}

export default Cards
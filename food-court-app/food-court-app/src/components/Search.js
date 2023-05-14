import React, { useEffect, useState } from 'react'
import Fooddata from './FoodData'
import "./style.css"
import Cards from './Cards'
import Set from './Set'
import Header from './Header'


const Search = () => {

  const [fdata] = useState(Fooddata);

  const [copydata, setCopyData] = useState([]);
  // console.log(copydata);

  const changedata = (e) => {
    let getchangedata = e.toLowerCase();

    if (getchangedata === "") {
      setCopyData(fdata);
    } else {
      let storedata = copydata.filter((ele, k) => {
        return ele.rname.toLowerCase().match(getchangedata);
      });

      setCopyData(storedata)
    }
  }

  useEffect(() => {

    setTimeout(() => {
      setCopyData(Fooddata);
    }, 500)

  }, [])

  return (
    <>
      <Header></Header>
      {/* <form className='container d-flex justify-content-center align-items-center mt-3'>
        <div className=" mx-2 col-lg-4" >

          <input type="text" class="form-control"
            onChange={(e) => changedata(e.target.value)} placeholder='Search Restaurant' />

        </div>
        <button className='btn text-light col-lg-1' style={{ background: "red" }}>Search</button>
      </form> */}

      <section className='item-section mt-4 container'>
        <h2 className='container d-flex justify-content-center align-items-center mt-3 px-4' style={{ fontWeight: 400 }}>Shops Available Are</h2>

        <div className='row mt-2 d-flex justify-content-center align-items-center'>
          {copydata && copydata.length ? <Cards data={copydata}></Cards> : <Set sdata={fdata}></Set>}
        </div>
      </section>

    </>
  )
}

export default Search
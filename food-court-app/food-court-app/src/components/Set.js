import React from 'react'
import Skeleton from '@mui/material/Skeleton';
import Stack from '@mui/material/Stack';

const set = ({sdata}) => {
    return (
        <>
        {
            sdata.map((ele,k)=>{
                return(
                    <>
                    <Stack spacing={1} style={{width:"40rem", paddingRight:"50px",paddingLeft:"50px"}} className="mt-3 mb-3">
                <Skeleton variant="rectangular" animation="wave" width={"34rem"} height={330} className="rounded" />
                <div className='d-flex justify-content-between'>
                    <Skeleton variant="text" animation="wave" width={"12rem"}/>
                    <Skeleton variant="text" animation="wave" width={"3rem"} />
                </div>
                <div className='d-flex justify-content-between'>
                    <Skeleton variant="text" animation="wave" width={"16rem"}/>
                    <Skeleton variant="text" animation="wave" width={"5rem"} />
                </div>
                <div className='d-flex justify-content-between align-content-center'>
                    <Skeleton variant="circular" animation="wave" width={30} height={25}/>
                    <Skeleton variant="text" animation="wave" width={"28rem"} />
                </div>
            </Stack>
                    </>
                )
            })
        }
            
        </>
    )
}

export default set
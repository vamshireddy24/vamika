import { useCallback, useState } from "react"
import React from 'react'

const SizeFilter = ({sizes,hidleTitle,multi=true}) => {
    const [appliedSize, setAppliedSize] = useState([]);
    const onClickDiv = useCallback((item) => {
        if (appliedSize.indexOf(item) > -1) {
            setAppliedSize(appliedSize?.filter(size => size !== item));
        }
        else {
            if(multi){
                setAppliedSize([...appliedSize,item]);
            }
            else{
                setAppliedSize([item]);
            }
        }
    },[appliedSize, setAppliedSize]);
        
    return (
        <div className={`flex flex-col ${hidleTitle?'':'mb-4'}`}>
            {!hidleTitle && <p className='text-[16px] text-black mt-5 mb-5'>Size</p>}
            <div className='flex flex-wrap px-2'>
                {sizes?.map((item, index) => {
                    return (
                        <div key={index} className='flex flex-col mr-2'>
                            <div className='w-[50px] h-8 border text-center mb-4 rounded-lg mr-4 cursor-pointer 
                            hover:scale-110 bg-white border-gray-500'style={appliedSize.includes(item)?{
                                background:'black',
                                color:'white'
                            }:{}} onClick={()=> onClickDiv(item)}>{item}</div>
                        </div>
                    )
                })}
            </div>
        </div>
    )
}

export default SizeFilter

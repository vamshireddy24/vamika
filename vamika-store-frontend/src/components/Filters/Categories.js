import React from 'react'

const categoriesData = [

]

const Categories = ({types}) => {
  return (
    <div>
      {types?.map((type,index)=>{
        return (
          <div key={index} className='flex items-center p-1'>
            <input type='checkbox' name={type?.code} className='border rounded-xl w-4 h-4 accent-black text-black'/>
            <label htmlFor={type?.code} className='px-4 text-[14px] text-gray-600'>{type?.name}</label>
          </div>
        )
      })}
    </div>
  )
}

export default Categories

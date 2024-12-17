import React from 'react'

const Card = ({imagePath,title, description,actionArrow,height,width}) => {
  return (
    <div className='flex items-center flex-col p-8'>
        <img className={`h-[${height? height:'220px'}] w-[${width? width:'200px'}] max-h-[180px] max-w-[140px] min-h-[180px] min-w-[140px] bg-cover bg-center
         border rounded hover:scale-105 cursor-pointer'`} src={imagePath} alt='Jeans'/>
         <div className='flex justify-between items-center'>
            <div className='flex flex-col'>
            <p className='text-[16px] p-1'>{title}</p>
            {description && <p className='text-[12px] px-2 text-gray-600'>{description}</p>}
            </div>
            {actionArrow && <span className='cursor-pointer pr-2 items-center'>ArrowIcon</span>}
        </div>
    </div>
  )
}

export default Card

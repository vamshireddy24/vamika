import React from 'react'

const SectionHeading = ({title}) => {
  return (
    <div className='felx flex-wrap px-10 my-5 items-center text-left gap-2'>
        <div className='border rounded border-1 bg-black w-2 h-6'>
        </div>
        <p className='text-2xl'>{title}</p>
    </div>
  )

}
export default SectionHeading

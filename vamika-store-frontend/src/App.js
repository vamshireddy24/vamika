import React from 'react';
import './App.css';
import HeroSection from './components/HerSection/HeroSection';
import NewArrivals from './components/Sections/NewArrivals';
import Category from './components/Sections/Categories/Category';
import content from './data/content.json';
import Footer from './components/Footer/Footer';

const App = () => {
  return (
    <>
      
      <HeroSection/>
      <NewArrivals/>
      {content?.categories && content?.categories?.map((item,index) => <Category key={item?.title+index} {...item}/>)}
      <Footer content={content?.footer}/>
    </>
  )
}

export default App

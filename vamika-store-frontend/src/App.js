import React from 'react';
import './App.css';
import Navigation from './components/Navigation/Navigation';
import HeroSection from './components/HerSection/HeroSection';
import NewArrivals from './components/Sections/NewArrivals';
import Category from './components/Sections/Categories/Category';
import content from './data/content.json';

const App = () => {
  return (
    <div className='App'>
      <Navigation/>
      <HeroSection/>
      <NewArrivals/>
      {content?.Categories && content?.Categories?.map((item, index) => <Category key={item?.title+index} {...item} />)}
    </div>
  )
}

export default App

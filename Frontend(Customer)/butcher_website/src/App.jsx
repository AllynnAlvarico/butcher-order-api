import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'

// import the components 
import Header from './components/header/Header.jsx'
import Main from './page/Main.jsx';

// import css
import './App.css'

/**
 * Client Website Interface 
 * > description 
 *  - This is the App.jsx react file that will contain and show all the pages
 *  - Including page container
 * > Create On 
 *  - Date: 25/12/2025
 *  - By: Anson Ling
 */
function App() {
  

  return (
    <>
      <Header />
      <Main />
    </>
  )
}

export default App

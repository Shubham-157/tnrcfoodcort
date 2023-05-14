import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Search from './components/Search';
import { BrowserRouter as Router, Route, Routes, Switch } from "react-router-dom";
import Menu1 from './components/Menu/Menu1'
import Menu2 from './components/Menu/Menu2'
import Menu3 from './components/Menu/Menu3'
import Menu4 from './components/Menu/Menu4'
import Menu5 from './components/Menu/Menu5'
import Menu6 from './components/Menu/Menu6'
import Cartdetails from './components/Menu/Cartdetails';
import Checkout from './components/Menu/Checkout';
import Login from './components/Login';
import Register from './components/Register';
import ContactForm from './components/ContactForm';
function App() {
  return (
   <>
    
    <Routes>
      <Route path='/' element={<Login></Login>}></Route>
      <Route path='/Register' element={<Register></Register>}></Route>
      <Route path='/Home' element={<Search></Search>}></Route>
      <Route path='/Menu1' element={<Menu1></Menu1>}></Route>
      <Route path='/Cart/:id' element={<Cartdetails></Cartdetails>}></Route>
      <Route path='/ContactForm' element={<ContactForm></ContactForm>}></Route>
      <Route path='/Menu2' element={<Menu2></Menu2>}></Route>
      <Route path='/Menu3' element={<Menu3></Menu3>}></Route>
      <Route path='/Menu4' element={<Menu4></Menu4>}></Route>
      <Route path='/Menu5' element={<Menu5></Menu5>}></Route>
      <Route path='/Menu6' element={<Menu6></Menu6>}></Route>
      <Route path='/Checkout' element={<Checkout></Checkout>}></Route>
    </Routes>
   </>
  );
}

export default App;

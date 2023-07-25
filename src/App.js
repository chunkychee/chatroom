import {Signup} from './Pages/signup'
import {BrowserRouter,Routes,Route} from 'react-router-dom';

 function App() {
  return (
    <div className="App">
      <BrowserRouter>

        <Routes>
          <Route path ="/signup" element={<Signup/>}/>

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

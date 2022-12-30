import AddTutorial from "./components/AddTutorial";
import TutorialsList from "./components/TutorialList";
import Tutorial from "./components/Tutorial";
import "./App.css";
import { Routes, Route, Link } from "react-router-dom";

const App = () => {
  return (
    <div>
      <nav className="navbar navbar-expand navbar-dark bg-dark">
        <Link to={"/tutorials"} className="navbar-brand">
          HieuLeXuan
        </Link>
        <div className="navbar-nav mr-auto">
          <li className="nav-item">
            <Link to={"/tutorials"} className="nav-link">
              Tutorials
            </Link>
          </li>
          <li className="nav-item">
            <Link to={"/add"} className="nav-link">
              Add
            </Link>
          </li>
        </div>
      </nav>
      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<TutorialsList />} />
          <Route path="/tutorials" element={<TutorialsList />} />
          <Route path="/add" element={<AddTutorial />} />
          <Route path="/tutorials/:id" element={<Tutorial />} />
        </Routes>
      </div>
    </div>
  );
};

export default App;

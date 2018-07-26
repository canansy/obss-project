import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App';
import links from './links';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<links/>, document.getElementById('root'));
registerServiceWorker();

import { Component } from "react";

class App extends Component {

  apiUrl = 'http://localhost:8080/stack'

  state = {};

  /**
   * Constructor to set up the state of the application
   * @param {*} props 
   */
  constructor(props) {
    super(props);
    this.state = {
      newInt: "",
      lastPoppedValue: "",
      stack: [],
      errorMessage: ""
    }
  }

  /**
   * Method used to initialise the component once mounted
   */
  componentDidMount() {
    this.get();
  }

  /**
   * Method to retrieve the state of the stack
   */
  get() {
    fetch(this.apiUrl)
      .then(response => response.json())
      .then(data => {
        this.setState({
          stack: data.stack
        })
      });
  }

  /**
   * Method to push the value to the stack
   */
  push() {
    const newInt = this.state.newInt;
    const pushRequest = {
      method: 'POST', 
      body: ''
    };
    fetch(this.apiUrl + '/push/' + newInt, pushRequest)
      .then(response => response.json())
      .then(data => this.setState({
        stack: data.stack
      }));
  }

  /**
   * Method to pop the last value off the stack
   */
  pop() {
    const newInt = this.state.newInt;
    fetch(this.apiUrl + '/pop')
      .then(response => response.json())
      .then(data => this.setState({
        stack: data.stack,
        lastPoppedValue: data.value
      }));
  }

  /**
   * Method used to update the state value used to push
   * @param {*} key 
   * @param {*} value 
   */
  updateInput(key, value) {
    this.setState({
      [key]: value
    });
  }

  /**
   * Method used to render the application
   * @returns 
   */

  render() {
    return (
      <div className="App">
        <div className="Input">
          Add new integer: 
          <input 
            type="text" 
            placeholder="Add number" 
            value={this.state.newInt}
            onChange={e => this.updateInput("newInt", e.target.value)}
            />
          <button
            onClick={() => this.push()}
          >Push</button>
          <button
            onClick={() => this.pop()}
          >Pop</button>
        </div>
        <div className="Output">
          <ul>
            {
              this.state.stack.map(item => {
                return (<li>{item}</li>)
              })
            }
          </ul>
          <div>
            Last Popped Value: {this.state.lastPoppedValue}
          </div>
        </div>
        <hr />
        <div className="KnownIssues">
          Please note that this application does not handle the errors thrown by the API. In order to create a simple application I learned the very basics of React JS in order to create this page. 
        </div>
      </div>
    )
  }
}

export default App;

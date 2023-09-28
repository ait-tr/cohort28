type Action = 
| { type: 'counter/minus', payload: number }
| { type: 'counter/plus', payload: number };

export default Action;
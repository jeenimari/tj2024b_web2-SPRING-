const ProductCard = (props) => {
    const {title, price, inStock} = props;
    
    const cssObj = {
      border: '1px solid #ddd',
      borderRadius: '4px',
      padding: '20px',
      margin: '10px',
      width: '200px',
      backgroundColor: 'white', 
      textAlign: 'center'
    };
    
    const titleStyle = {
      margin: '0 0 20px 0',
      fontSize: '18px',
      fontWeight: 'bold'
    };
    
    return (
      <div style={cssObj}>
        <h2 style={titleStyle}>
          {title}
        </h2>
        <p style={{margin: '10px 0'}}>
          가격: {price.toLocaleString()}
        </p>
        <p style={{
          margin: '10px 0',
          color: inStock ? 'green' : 'red'
        }}>
          {inStock ? '재고 있음' : '재고 없음'}
        </p>
      </div>
    );
  };
  
  // 메인
  export default function Task(props) {
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    
    return (
      <div style={{
        display: 'flex',
        justifyContent: 'center',
        padding: '20px'
      }}>
        {products.map((product, index) => (
          <ProductCard
            key={index}
            title={product.title}
            price={product.price}
            inStock={product.inStock}
          />
        ))}
      </div>
    );
  }
// este componente pode ser utilizado com outras opções de paginação futuras
import { SalePage } from "types/sales";

type Props = {
    page : SalePage;
    onPageChange: Function; // criado para comunicação entre os componentes (pagination com datatable)
}


// criado uma estrutura page do tipo Props que traz as informacoes da SalePage que é o DataTable paginado
const Pagination = ({ page, onPageChange } : Props) => {
    return (
        //layout visto no bootstrap e preparado para a ocasiao para visualizar as opções de navegação do DataTable //retirado row antes do d-flex
        //<li className={`page-item ${page.first ? 'disabled' : '' } `}> este comando verifica se é a primeira pagina e desabilita o botão anterior se for true, ou caso contrario mantem
        //onClick={() => onPageChange(page.number - 1)} este comando detecta no clique do Anterior e atribui -1 para mudar a pagina
       <div className="d-flex justify-content-center">
            <nav>
                <ul className="pagination">
                    <li className={`page-item ${page.first ? 'disabled' : ''} `}>
                        <button className="page-link" onClick={() => onPageChange(page.number - 1)}>Anterior</button>
                    </li>
                    <li className="page-item disabled">
                        <span className="page-link">{page.number + 1}</span>
                    </li>
                    <li className={`page-item ${page.last ? 'disabled' : ''} `}>
                        <button className="page-link" onClick={() => onPageChange(page.number + 1)} >Próxima</button>
                    </li>
                </ul>
            </nav>
        </div>
    )
}

export default Pagination;
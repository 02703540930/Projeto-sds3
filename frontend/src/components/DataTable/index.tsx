import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sales";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {
    const [activePage, setActivePage] = useState(0);  // funcao para mudanca de paginas

    //configuração da paginacao que vem lá da requisicao postman e criada no type.ts
    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0,
    });

    //usado para executar somente quando a pagina carregar, fara apenas uma execucao
    //está atrelado ao activePage, quando alterar nos botoes de navegacao do Pagination
    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
            .then(response => {
                setPage(response.data);          //response.data eh a resposta da requisicao entre crases. o setPage está no formato da resposta
                // e o SalePage contem os campos identicos do banco de dados. monstrando assim na pagina os dados vindos do banco.
            });
    }, [activePage]);

    //indice criado para ser o numero da pagina ativa
    const changePage = (index: number) => {
        setActivePage(index)
    }

    // pagination com dados de pagina(page) e funcao que navega entre as paginas(changePage)
    return (
        <> 
        <Pagination page={page} onPageChange={changePage}/>
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Vendedor</th>
                            <th>Clientes visitados</th>
                            <th>Negócios fechados</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content?.map(item => (    //busca dentro do content que sao todos os registos do detalhe. tr com key id do registro pq o rect exige uma chave para cada item de uma coleção de dados
                            //<tr>
                            <tr key={item.id}>
                                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                                <td>{item.seller.name}</td>
                                <td>{item.visited}</td>
                                <td>{item.deals}</td>
                                <td>{item.amount.toFixed(2)}</td>
                            </tr>
                        ))}

                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;
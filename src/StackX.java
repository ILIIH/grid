class StackX
{
    private final int SIZE = 20;
    private int[] st;
    private int top;
    // -----------------------------------------------------------
    public StackX()
// Конструктор
    {
        st = new int[SIZE];
// Создание массива
        top = -1;
    }
    // -----------------------------------------------------------
    public void push(int j)
// Размещение элемента в стеке
    { st[++top] = j; }
    // -----------------------------------------------------------
    public int pop()
// Извлечение элемента из стека
    { return st[top--]; }
    // ------------------------------------------------------------
    public int peek()
// Чтение с вершины стека
    { return st[top]; }
    // ------------------------------------------------------------
    public boolean isEmpty() // true, если стек пуст
    { return (top == -1); }
// ------------------------------------------------------------
} // Конец класса StackX
////////////////////////////////////////////////////////////////

class Graph2
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // Список вершин
    private int adjMat[][];
    // Матрица смежности
    private int nVerts;
    // Текущее количество вершин
    private StackX theStack;

    public Graph2()
    {
        vertexList = new Vertex[MAX_VERTS];
// Матрица смежности
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)

            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
        theStack = new StackX();
    }
public void addVertex(char lab)
{
    vertexList[nVerts++] = new Vertex(lab);
}
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    public void dfs() // Обход в глубину
    {
        vertexList[0].wasVisited = true; // Пометка
        displayVertex(0);
        theStack.push(0);
        while( !theStack.isEmpty() )
        {
            int v = getAdjUnvisitedVertex( theStack.peek() );
            if(v == -1)
                theStack.pop();
            else
            {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for(int j=0; j<nVerts; j++)
            vertexList[j].wasVisited = false;
    }
    public int getAdjUnvisitedVertex(int v)
    {
        for(int j=0; j<nVerts; j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
                return j;
        return -1;
    }
}

class DFSApp
{
    public static void main(String[] args)
    {
        Graph2 theGraph = new Graph2();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);

        System.out.print("Visits: ");
        theGraph.dfs();
// Обход в глубину
        System.out.println();
    }
} // Конец класса DFSApp
////////////////////////////////////////////////////////////////

package exer19;

public interface Escalavel {

	/**
   	 * O método amplia modifica os campos do objeto para alterar o seu tamanho.
   	 * @param escala a escala para modificação do objeto
   	 */
   	void amplia(double escala);
 
   	/**
   	 * O método espelha modifica os campos do objeto para alterar a sua posição (fazendo
   	 * com que o objeto fique refletido nas suas coordenadas horizontais)
   	 * @throws Exception 
   	 */
   	void espelha() throws Exception;
}

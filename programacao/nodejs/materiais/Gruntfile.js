//npm instll grunt --save-dev
//npm install grunt-cli -g
//bower
//npm install grunt-contrib-copy

module.exports = function(grunt){

	grunt.initConfig({

		copy: {

			public:{
				expand: true,
				cwd: 'app/public',
				src: '**',
				dest: 'app/dist'
			}
	
		},

		clean: {
			dis:{
				src: 'app/dist'
			}
		},

		 less: {
	      development: {
	        files: {
	          "app/public/css/estilo_produtos.css":
	           "app/public/css/estilo_produtos.less" // Caminho dos arquivos
	        }
	      }

    	},

    	watch: {
		  styles: {
		    files: ['**/*.less'], // Quais arquivos o grunt ficará de olho
		    tasks: ['less']
		 }
		} 

	
	});

	//registra ordens das tarefas
	grunt.registerTask('dist', ['clean', 'copy']);
	grunt.registerTask('compilarless',['less', 'watch']);
	grunt.registerTask('default','dist');


	//carrega as dependecias
	grunt.loadNpmTasks('grunt-contrib-copy');//copia diretorio
	grunt.loadNpmTasks('grunt-contrib-clean');//apaga diretorio
	grunt.loadNpmTasks('grunt-contrib-less');//apaga diretorio
	grunt.loadNpmTasks('grunt-contrib-watch');
  //mimificar
  //juntar arquivos
  //uglify
  //otimizar imagens
  //automatizar less
	//gzip
	//cache	
}
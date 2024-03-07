class Complement
  def self.of_nucleotide(nucleotide)
    return '' if nucleotide == ''

    return 'C' if nucleotide == 'G'

    return 'A' if nucleotide == 'T'

    return 'U' if nucleotide == 'A'

    'G' if nucleotide == 'C'
  end

  def self.of_dna(rna_sequence)
    rna_sequence.chars.map { |nucleotide| of_nucleotide(nucleotide) }.join
  end
end
